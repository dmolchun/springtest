import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from "rxjs/Observable";
import {User} from "../users/user";

@Injectable()
export class LoginService {

  private loginUrl = 'login';
  private currentUserUrl = 'app/user/info';

  constructor(private httpClient: HttpClient) {
  }

  login(username: string, password: string): Observable<any> {
    var credentials = new HttpParams()
      .set('username', username)
      .set('password', password);

    const options = {responseType: 'text' as 'text'};

    return this.httpClient.post(
      this.loginUrl,
      credentials,
      {responseType: 'text' as 'text'});
  }
  getCurrentUser(): Observable<User> {
    return this.httpClient.get<User>(this.currentUserUrl);
  }
}
