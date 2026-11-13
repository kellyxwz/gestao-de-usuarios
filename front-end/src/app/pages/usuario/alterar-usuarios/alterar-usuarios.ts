import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-alterar-usuarios',
  standalone: false,
  templateUrl: './alterar-usuarios.html',
  styleUrl: './alterar-usuarios.scss',
})
export class AlterarUsuarios {
  @Output() cancelar = new EventEmitter<void>();



}
