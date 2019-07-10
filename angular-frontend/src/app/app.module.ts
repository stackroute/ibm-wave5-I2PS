import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// import { Observable } from 'rxjs/observable';


import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { NavbarModule, WavesModule, ButtonsModule, CardsFreeModule, CheckboxModule} from 'angular-bootstrap-md';
import { RecentIdeasComponent } from './recent-ideas/recent-ideas.component';
import { ModalSuccessComponent } from './modal-success/modal-success.component';
import { AboutComponent } from './about/about.component';
import { HomeComponent } from './home/home.component'
import { HttpClientModule } from '@angular/common/http';
import { ServiceProviderRegistrationComponent } from './service-provider-registration/service-provider-registration.component';

import { InputsModule, IconsModule} from 'angular-bootstrap-md';

import { CustomMaterialModule } from './core/material.module';
import { DropdownModule } from 'angular-bootstrap-md';
import {MatDialogModule, MatDialogRef} from '@angular/material/dialog'

import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatStepperModule, MatInputModule, MatButtonModule,MatSelectModule} from '@angular/material';
import { PostIdeaComponent } from './post-idea/post-idea.component';
import { InnovatorRegistrationComponent } from './innovator-registration/innovator-registration.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { ServiceProviderDashboardComponent } from './service-provider-dashboard/service-provider-dashboard.component';
import { ServiceProviderProfileComponent } from './service-provider-profile/service-provider-profile.component';
import { InnovatorProfileComponent } from './innovator-profile/innovator-profile.component';
import { InnovatorDashboardComponent } from './innovator-dashboard/innovator-dashboard.component';
import { PostIdeaServiceService } from './post-idea-service.service';
import { FooterComponent } from './footer/footer.component';
import { SnavbarComponent } from './snavbar/snavbar.component';
import { IntelligentServiceComponent } from './intelligent-service/intelligent-service.component';


// import { MatAutocomplete } from '@angular/material';




@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    RecentIdeasComponent,
    ModalSuccessComponent,
    AboutComponent,
    HomeComponent,
    ServiceProviderRegistrationComponent,
    PostIdeaComponent,
    InnovatorRegistrationComponent,
    UserLoginComponent,
    ServiceProviderDashboardComponent,
    ServiceProviderProfileComponent,
    InnovatorProfileComponent,
    InnovatorDashboardComponent,
    FooterComponent,
    SnavbarComponent,
    IntelligentServiceComponent,
    
  ],
  imports: [
    BrowserModule,
    
    AppRoutingModule,
    MDBBootstrapModule.forRoot(),
    NavbarModule, WavesModule, ButtonsModule,CardsFreeModule,CheckboxModule,InputsModule, IconsModule, 
    HttpClientModule,
    CustomMaterialModule,
    FormsModule, ReactiveFormsModule,
    BrowserAnimationsModule,
    MatStepperModule, MatInputModule, MatButtonModule,MatSelectModule,MatDialogModule
  ],
  providers: [PostIdeaServiceService, {provide: MatDialogRef, useValue: {}},],
  bootstrap: [AppComponent]
})
export class AppModule { }
