import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/internal/Observable";
import { Options } from 'selenium-webdriver';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SignUpService {
  private urlcategory = "http://localhost:8181/api/user/register";

  constructor(private _httpCall: HttpClient) { }
  
  signMeUp(body: any): Observable<any> {
    var data = JSON.stringify(body);

    console.log("Lolololol");
    return this._httpCall.post(environment.apiUrl, data);
  }
}
