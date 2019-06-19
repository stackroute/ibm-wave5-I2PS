import { Component, OnInit } from '@angular/core';
import { FormGroup } from "@angular/forms";
import { FormBuilder } from "@angular/forms";
import { Validators } from "@angular/forms";


@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {

  title = 'materialApp';   
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  constructor(private _formBuilder: FormBuilder) {}
  ngOnInit() {
     this.firstFormGroup = this._formBuilder.group({
        firstCtrl: ['', Validators.required]
     });
     this.secondFormGroup = this._formBuilder.group({
        secondCtrl: ['', Validators.required]
     });
  }
}


