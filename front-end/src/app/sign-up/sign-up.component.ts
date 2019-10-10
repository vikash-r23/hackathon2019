import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder} from '@angular/forms';
import {MustMatch} from './must-match.validator'
import { match } from 'minimatch';
import {SignUpService} from "../../dataService/sign-up.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})

export class SignUpComponent implements OnInit{
  signUpForm : FormGroup;
  submitted = false;

  constructor(private signUpService: SignUpService, private formBuilder: FormBuilder, private router:Router){
  }

  ngOnInit(){
    this.signUpForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      userName: ['', Validators.email],
      mobileNumber: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]],
      password: ['', Validators.minLength(6)],
      confirmPassword: ['', Validators.required], 
      userType: ['', Validators.required],
      acceptTerms: [false, Validators.requiredTrue]
    }, {
      validator: MustMatch('password', 'confirmPassword')
  });
  }

  get f() { return this.signUpForm.controls; }
  log(x){
    console.log(x);
  }

  onSubmit() {
    console.log("Yayy");
    this.submitted = true;
    var formData: any = new FormData();
    // stop here if form is invalid
    if (this.signUpForm.invalid) {
      console.log("invalid");
        return;
    }
    console.log("valid");
    //console.log(this.signUpForm.value);
    delete this.signUpForm.value['acceptTerms'];
    //console.log(this.signUpForm.value);
    this.signUpForm.value["enabled"]="Y";
    console.log(JSON.stringify(this.signUpForm.value));
    this.signUpService.signMeUp(this.signUpForm.value).subscribe((data)=>{
      this.router.navigate(['/signIn']);
    });
}
}
