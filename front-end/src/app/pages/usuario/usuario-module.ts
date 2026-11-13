import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { UsuarioRoutingModule } from './usuario-routing-module';
import { WrapperUsuarios } from './wrapper-usuarios/wrapper-usuarios';
import { ListarUsuarios } from './listar-usuarios/listar-usuarios';
import { CadastrarUsuarios } from './cadastrar-usuarios/cadastrar-usuarios';
import { AlterarUsuarios } from './alterar-usuarios/alterar-usuarios';
import { UsuarioService } from './usuario-service';
import { MatPaginatorModule } from '@angular/material/paginator';


@NgModule({
  declarations: [
    WrapperUsuarios,
    ListarUsuarios,
    CadastrarUsuarios,
    AlterarUsuarios
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    UsuarioRoutingModule,
    MatPaginatorModule
  ],
  providers: [
    UsuarioService
  ]
})
export class UsuarioModule { }
