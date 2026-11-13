import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WrapperUsuarios } from './wrapper-usuarios/wrapper-usuarios';
import { ListarUsuarios } from './listar-usuarios/listar-usuarios';
import { CadastrarUsuarios } from './cadastrar-usuarios/cadastrar-usuarios';
import { AlterarUsuarios } from './alterar-usuarios/alterar-usuarios';

const routes: Routes = [
  {
    path: '',
    component: WrapperUsuarios,
    children: [
      { path: '', redirectTo: 'listar', pathMatch: 'full' },
      { path: 'listar', component: ListarUsuarios },
      { path: 'cadastrar', component: CadastrarUsuarios },
      { path: 'alterar/:id', component: AlterarUsuarios },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsuarioRoutingModule { }
