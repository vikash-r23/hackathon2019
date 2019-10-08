import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SignInService } from "../../dataService/sign-in.service"

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {

  signInForm: FormGroup;

  constructor(private signInService: SignInService, private formBuilder: FormBuilder) { }

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
      console.log(data);
      
    });
  }
}
