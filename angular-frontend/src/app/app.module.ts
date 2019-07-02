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
import { LandingPageComponent } from './landing-page/landing-page.component';
import {SericeProviderComponent} from './service-provider-registration/serice-provider.component';
import { RegistrationService } from './registration.service';
import { InnovatorProfileComponent } from './innovator-profile-registration/innovator-profile.component';
import { IntelligentServiceComponent } from './intelligent-service/intelligent-service.component';
import { CardDetailsComponent } from './card-details/card-details.component';
import {ServiceProviderProfileDashbaordComponent} from './service-provider-profile-dashbaord/service-provider-profile-dashbaord.component';
import {InnovatorProfileDashboardComponent }from './innovator-profile-dashboard/innovator-profile-dashboard.component'



@NgModule({
  declarations: [
    AppComponent,
    UserLoginComponent,
    LandingPageComponent,
    SericeProviderComponent,
    InnovatorProfileComponent,
    IntelligentServiceComponent,
    CardDetailsComponent,
   ServiceProviderProfileDashbaordComponent,
   InnovatorProfileDashboardComponent
    
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
    ReactiveFormsModule,
    // SericeProviderComponent
  ],
  providers: [LoginService,RegistrationService],
  bootstrap: [AppComponent],
 

})
export class AppModule { }
