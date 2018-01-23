import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from "rxjs/Observable";

@Injectable()
export class LoginService {

  private loginUrl = 'login';

  constructor(private httpClient: HttpClient) {
  }

  login(username: string, password: string): Observable<any> {
    var credentials = new HttpParams()
      .set('username', username)
      .set('password', password);

    const options = {responseType: 'text' as 'text'};

    return this.httpClient.post<any>(
      this.loginUrl,
      credentials,
      {responseType: 'text' as 'text'});
  }
}
