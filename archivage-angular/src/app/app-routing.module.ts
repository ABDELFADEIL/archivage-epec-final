import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';
import {PreLoginComponent} from './pre-login/pre-login.component';
import {ClientsComponent} from './clients/clients.component';
import {ContractsComponent} from './contracts/contracts.component';
import {AccountsComponent} from './accounts/accounts.component';
import {NewClientComponent} from './new-client/new-client.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {NewAccountComponent} from './new-account/new-account.component';
import {NewContractComponent} from './new-contract/new-contract.component';
import {DocumentsComponent} from './documents/documents.component';
import {DocumentsToDestroyComponent} from './documents-to-destroy/documents-to-destroy.component';
import {DocumentsToBeValidatedComponent} from './documents-to-be-validated/documents-to-be-validated.component';
import {DocumentsDestroyedComponent} from './documents-destroyed/documents-destroyed.component';
import {UpdateDfpmDocComponent} from './update-dfpm-doc/update-dfpm-doc.component';
import {HistoryComponent} from './history/history.component';
import {ClassificationNatureComponent} from './classification-nature/classification-nature.component';


const routes: Routes = [
  { path: 'pre-login', component: PreLoginComponent},
  { path: 'login', component: LoginComponent},
  { path: 'home', component: HomeComponent, data : {title:'Accueil'}},
  { path: 'clients', component: ClientsComponent, data : {title:'clients'}},
  { path: 'new-client', component: NewClientComponent, data : {title:'nouveau client'}},
  { path: 'contracts', component: ContractsComponent, data : {title:'contrats'}},
  { path: 'new-contract', component: NewContractComponent, data : {title:'nouveau contrat'}},
  { path: 'accounts', component: AccountsComponent, data : {title:'comptes'}},
  { path: 'new-account', component: NewAccountComponent, data : {title:'nouveau compte'}},
  { path: 'documents', component: DocumentsComponent, data : {title:'documents'}},
  { path: 'documents-to-validated', component: DocumentsToBeValidatedComponent, data : {title:'Documents à valider'}},
  { path: 'documents-to-destroyed', component: DocumentsToDestroyComponent, data : {title:'Documents à détruire'}},
  { path: 'documents-destroyed', component: DocumentsDestroyedComponent, data : {title:'Documents détruits'}},
  { path: 'update-dfpm-document', component: UpdateDfpmDocComponent, data : {title:'Mis à jour DFPM'}},
  { path: 'history', component: HistoryComponent, data : {title:'Historique'}},
  { path: 'classifcation-nature', component: ClassificationNatureComponent, data : {title:'Classification nature'}},
  { path: '',  redirectTo: 'home', pathMatch: 'full'},
  { path: '**', component: NotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
