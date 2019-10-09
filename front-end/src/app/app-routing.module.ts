import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SignInComponent } from "./sign-in/sign-in.component";
import { IdeasComponent } from "./ideas/ideas.component";
import { AdminComponent } from "./admin/admin.component";
import { InvestorComponent } from "./investor/investor.component";
import { StartUpsComponent } from "./start-ups/start-ups.component";
import {SignUpComponent} from "./sign-up/sign-up.component";
import {CreateIdeaComponent} from "./create-idea/create-idea.component";

const routes: Routes = [
  {path: '', redirectTo: '/signIn', pathMatch: 'full' },
  { path: '', redirectTo: '/ideas', pathMatch: 'full' },
  {path:'signIn', component: SignInComponent},
  {path:'ideas', component: IdeasComponent},
  {path:'admin', component: AdminComponent},
  {path:'investor', component: InvestorComponent},
  {path:'startUps', component: StartUpsComponent},
  {path:'signUp', component: SignUpComponent},
  {path:'createIdea', component: CreateIdeaComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {enableTracing: false, useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [IdeasComponent, AdminComponent, InvestorComponent, StartUpsComponent, SignUpComponent, CreateIdeaComponent];
