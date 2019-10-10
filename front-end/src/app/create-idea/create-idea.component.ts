import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { IdeasComponent } from '../ideas/ideas.component';
import { IdeasService } from 'src/dataService/ideas.service';
import { SignInService } from 'src/dataService/sign-in.service';

@Component({
  selector: 'app-create-idea',
  templateUrl: './create-idea.component.html',
  styleUrls: ['./create-idea.component.scss']
})
export class CreateIdeaComponent implements OnInit {

  createIdeaForm : FormGroup;
  submitted = false;

  constructor(private formBuilder : FormBuilder, private ideaService : IdeasService, private signinService : SignInService){}

  ngOnInit(){
    console.log("INIT");
    this.createIdeaForm = this.formBuilder.group({
        ideaName : ['', Validators.required],
        description : ['', Validators.required],
        company : ['', Validators.required],
        usp : ['', Validators.required],
        roi : ['', Validators.required],
        address : ['', Validators.required],
        contact : ['', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]],
        alternateContact : ['', [Validators.minLength(10), Validators.maxLength(10)]],
        email : ['', [Validators.required, Validators.email]],
        website : ['', Validators.pattern('https?://.+')],
        insta : [''],
        youtube : [''],
        linkedin : ['']
    })
  }

  get f(){
    // console.log("called");
    return this.createIdeaForm.controls;
  }

  onSubmit(){
    // console.log("Submitted");
    this.submitted = true;
    if(this.createIdeaForm.invalid){
      console.log("Invalid!!");
      
    }
    const body = this.createIdeaForm.value;
    body["pitcherId"] = this.signinService.userDetails.userId;
    this.ideaService.createIdea(body,this.signinService.userDetails.jwttoken).subscribe(data => console.log(data));
    console.log(this.createIdeaForm.value);
  }

}
