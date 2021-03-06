import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';

import { MyDateRangePickerModule } from 'mydaterangepicker';
import { NgbModule, NgbTimepicker } from '@ng-bootstrap/ng-bootstrap';

import { AgGridModule } from "ag-grid-angular";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NoopAnimationsModule } from "@angular/platform-browser/animations";
import { NgxChartsModule } from "@swimlane/ngx-charts";
import { HttpClientModule } from "@angular/common/http";
import { AdminComponent } from './admin/admin.component';
import { InvestorComponent } from './investor/investor.component';
import { StartUpsComponent } from './start-ups/start-ups.component';
import { IdeasComponent } from './ideas/ideas.component';

import { IdeasService } from "../dataService/ideas.service";
import { InvestorService } from "../dataService/investor.service";
import { SignInService } from "../dataService/sign-in.service";
import { StartUpService } from "../dataService/start-up.service";
import { AdminService } from "../dataService/admin.service";

import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CreateIdeaComponent } from './create-idea/create-idea.component'; // <== add the imports!


@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    InvestorComponent,
    StartUpsComponent,
    IdeasComponent,
    routingComponents,
    SignInComponent,
    SignUpComponent,
    CreateIdeaComponent
  ],
  imports: [
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    NgxChartsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MyDateRangePickerModule,
    NgbModule,
    AgGridModule.withComponents([AppComponent])
  ],
  providers: [IdeasService, InvestorService, SignInService, StartUpService, AdminService],
  bootstrap: [AppComponent]
})
export class AppModule { }
