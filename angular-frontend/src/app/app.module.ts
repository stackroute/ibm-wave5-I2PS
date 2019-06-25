import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CustomMaterialModule } from './core/material.module';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatStepperModule, MatInputModule, MatButtonModule} from '@angular/material'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserLoginComponent } from './user-login/user-login.component';

import { LoginService } from './login.service';
import { HttpClientModule } from '@angular/common/http';
import { InnovatorProfileComponent } from './innovator-profile-registration/innovator-profile.component';


@NgModule({
  declarations: [
    AppComponent,
    UserLoginComponent,
    InnovatorProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CustomMaterialModule,
    BrowserAnimationsModule,
    MatStepperModule, 
    MatInputModule, 
    MatButtonModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
