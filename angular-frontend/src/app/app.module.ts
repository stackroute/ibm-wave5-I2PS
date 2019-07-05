import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CustomMaterialModule } from './core/material.module';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatStepperModule, MatInputModule, MatButtonModule,MatSelectModule} from '@angular/material'

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
import { PostIdeaComponent } from './post-idea/post-idea.component';
import { MatAutocomplete } from '@angular/material';
import { NewIdeaProfileComponent } from './innovator-dashboard/new-idea-profile.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { ServiceProviderProfileDashbaordComponent } from './service-provider-profile-dashbaord/service-provider-profile-dashbaord.component';

@NgModule({
  declarations: [
    AppComponent,
    UserLoginComponent,
    LandingPageComponent,
    SericeProviderComponent,
    InnovatorProfileComponent,
    IntelligentServiceComponent,
    CardDetailsComponent,
    PostIdeaComponent,
    NewIdeaProfileComponent,
    NavbarComponent,
    FooterComponent,
    ServiceProviderProfileDashbaordComponent

    
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
    MatSelectModule
    // MatAutocomplete
    // SericeProviderComponent
  ],
  providers: [LoginService,RegistrationService],
  bootstrap: [AppComponent],
 

})
export class AppModule { }
