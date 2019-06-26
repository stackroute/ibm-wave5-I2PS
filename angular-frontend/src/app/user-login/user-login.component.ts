import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import { LoginService } from '../login.service';

// import  { JwtHelperService } from '@auth0/angular-jwt';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  loggedIn:any = null;

  constructor(private loginService:LoginService, private route: ActivatedRoute, private router:Router) { }
  arrayOfUser:any=[];

  // helper = new JwtHelperService();

  ngOnInit() {
    console.log("in ngoninit")
  }

  authenticateUser(userName, password) {
    console.log("in authenticateUser " + userName  +password);
    let userdata = {
      userName:userName,
      password: password
    }
    this.loginService.authenticateUser(userdata);
  
   
  //   this.loginService.authenticateUser(userdata).subscribe(data => {
  //   console.log(data)
  //   if (data.token) {

  //    let role =  this.helper.decodeToken(data.token).aud;
  //    console.log(data.token);
  //    if (role === 'Innovator') {
  //     this.router.navigateByUrl('/innovator-profile')
  //    }
  //    if(role === '!Innovator') {
  //     this.router.navigateByUrl('/service-provider')
  //    }
  //   }
  //   else{
  //     this.loggedIn = true;
  //   }

  //   }, err  => {
  //     this.loggedIn = true;
  //   })
}

}


