import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserLoginComponent } from './user-login/user-login.component';
// import { ServiceProviderComponent } from './service-provider-registration/serice-provider.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { InnovatorProfileComponent } from './innovator-profile-registration/innovator-profile.component';
import { SericeProviderComponent } from './service-provider-registration/serice-provider.component';
import { IntelligentServiceComponent } from './intelligent-service/intelligent-service.component';
import { CardDetailsComponent } from './card-details/card-details.component';
import { PostIdeaComponent } from './post-idea/post-idea.component';
import { NewIdeaProfileComponent } from './innovator-dashboard/new-idea-profile.component';


const routes: Routes = [  
  { path: 'login', component:UserLoginComponent },
  {path: 'serviceprovider',component:SericeProviderComponent},
  { path: 'landingpage',component:LandingPageComponent},
  {path: 'innovatorprofile',component:InnovatorProfileComponent},
  {path: 'intelligent-service',component:IntelligentServiceComponent},
  {path: 'cardDetail/:id',component:CardDetailsComponent},
  { path: 'post', component:PostIdeaComponent},
  {path: 'xyz', component: NewIdeaProfileComponent}
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
