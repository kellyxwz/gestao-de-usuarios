import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Usuario } from '../models/usuario';
import { UsuarioService } from '../usuario-service';

@Component({
  selector: 'app-cadastrar-usuarios',
  standalone: false,
  templateUrl: './cadastrar-usuarios.html',
  styleUrl: './cadastrar-usuarios.scss',
})

export class CadastrarUsuarios {
  @Output() cancelar = new EventEmitter<void>();
  @Output() cadastrado = new EventEmitter<Usuario>();

  form: FormGroup;
  erroCadastro = false;
  enviando = false;

  
  constructor(
    private fb: FormBuilder,
    private usuarioService: UsuarioService
  ) {
    this.form = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      role: ['', Validators.required]
    });
  }


  cadastrarUsuario(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    this.erroCadastro = false;
    this.enviando = true;

    const usuario = this.form.getRawValue() as Usuario;

    this.usuarioService.cadastrar(usuario).subscribe({
      next: (usuarioCadastrado) => {
        this.cadastrado.emit(usuarioCadastrado);
        this.form.reset()
        this.enviando = false;
      },
      error: (httpError) => {
        this.enviando = false;

        const errorBack = httpError.error;

        if (
          httpError.status === 409 && 
          errorBack?.message == 'Email já cadastrado'
        ) {
          this.form.get('email')?.setErrors({ emailCadastrado: true });
        } else {
          this.erroCadastro = true;
        }
      }
    });
  }
}
