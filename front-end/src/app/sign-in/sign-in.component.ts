import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SignInService } from "../../dataService/sign-in.service"

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {

  
  signInForm: FormGroup;

  constructor(private signInService: SignInService, private formBuilder: FormBuilder, private router:Router) { }

  ngOnInit() {
    this.signInForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  authenticateUser(username, password) {
    if (this.signInForm.invalid) {
      // return;
    }
    let userDetails = {
      username: username,
      password: password
    };

    this.signInService.authenticateUser(userDetails).subscribe((data)=>{
      this.router.navigate(['/ideas']);
      this.signInService.userDetails=data;
    });
  }

  redirectTo() {
    this.router.navigate(['/signUp']);
  }
}
