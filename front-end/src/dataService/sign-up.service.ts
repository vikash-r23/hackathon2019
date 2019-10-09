import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/internal/Observable";
import { Options } from 'selenium-webdriver';

@Injectable({
  providedIn: 'root'
})
export class SignUpService {
  private urlcategory = "http://griiin.southindia.cloudapp.azure.com:8080/api/user/register";

  constructor(private _httpCall: HttpClient) { }
  
  signMeUp(body: Object): Observable<Object> {
    return this._httpCall.post(this.urlcategory, body);
  }
}

