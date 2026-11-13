import { Component, computed, OnInit, signal } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from '../usuario-service';
import { Usuario } from '../models/usuario';

@Component({
  selector: 'app-listar-usuarios',
  standalone: false,
  templateUrl: './listar-usuarios.html',
  styleUrl: './listar-usuarios.scss',
})
export class ListarUsuarios implements OnInit {
  protected readonly usuarios = signal<Usuario[]>([]);
  protected tamanhoPagina = signal<number>(5);
  protected indicePagina = signal<number>(0);

  protected mostrandoCadastro = false;

  constructor(
    private usuarioService: UsuarioService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.listar();
  }

  usuariosPaginados = computed(() => {
    const inicio = this.indicePagina() * this.tamanhoPagina();
    const fim = inicio + this.tamanhoPagina();
    return this.usuarios().slice(inicio, fim);
  });

  totalPaginas = computed(() =>
    Math.ceil(this.usuarios().length / this.tamanhoPagina())
  );

  listar(): void {
    this.usuarioService.listar().subscribe(usuarios => {
      this.usuarios.set(usuarios);
      this.indicePagina.set(0);
    });
  }

  paginaAnterior(): void {
    if (this.indicePagina() > 0) {
      this.indicePagina.update(indice => indice - 1);
    }
  }

  proximaPagina(): void {
    if (this.indicePagina() < this.totalPaginas() - 1) {
      this.indicePagina.update(indice => indice + 1);
    }
  }

  abrirCadastro(): void {
    this.mostrandoCadastro = true;
  }

  fecharCadastro(): void {
    this.mostrandoCadastro = false;
  }

  alterar(id: number): void {
    this.router.navigate(['/usuarios/alterar', id]);
  }

  excluir(usuario: Usuario): void {
    const confirmado = window.confirm(`Deseja excluir o usuário "${usuario.name}"?`);

    if (!confirmado) {
      return;
    }

    this.usuarioService.excluir(usuario.id).subscribe({
      next: () => {
        this.usuarios.update(usuarios =>
          usuarios.filter(item => item.id !== usuario.id)
        );
        const totalAposExclusao = this.usuarios().length;
        const maxPaginas = Math.ceil(totalAposExclusao / this.tamanhoPagina());
        if (this.indicePagina() >= maxPaginas && this.indicePagina() > 0) {
          this.indicePagina.update(p => p - 1);
        }
      },
      error: () => {
        window.alert('Não foi possível excluir o usuário.');
      },
    });
  }
}
