import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
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

  @ViewChild('addIdeaModal', {static: false}) noteModal: ElementRef;
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
    return this.createIdeaForm.controls;
  }

  onSubmit(){
    this.submitted = true;
    if(this.createIdeaForm.invalid){
      console.log("Invalid!!");
      
    }
    const body = this.createIdeaForm.value;
    body["pitcherId"] = this.signinService.userDetails !== undefined ? this.signinService.userDetails.userId : 0;
    this.ideaService.createIdea(body,this.signinService.userDetails.jwttoken).subscribe(data => {console.log(data)
    });
    console.log(this.createIdeaForm.value);
  }

}
