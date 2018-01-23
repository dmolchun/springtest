import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from "./user";
import {Observable} from "rxjs/Observable";

@Injectable()
export class UsersService {

  private usersUrl = 'app/user/users';
  private currentUserUrl = 'app/user/info';

  constructor(private http: HttpClient) {
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }

  getCurrentUser(): Observable<User> {
    return this.http.get<User>(this.currentUserUrl);
  }
}
