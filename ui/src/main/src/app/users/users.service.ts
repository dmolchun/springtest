import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from "./user";
import {Observable} from "rxjs/Observable";

@Injectable()
export class UsersService {

  private usersUrl = 'app/user/users';
  private usersByIdUrl = 'app/user/id/';
  private rolesUrl = 'app/user/roles';
  private currentUserUrl = 'app/user/info';
  private saveUserUrl = 'app/user/save';
  private changePasswordUrl = 'app/user/password';

  private currentUser: User;

  constructor(private http: HttpClient) {
    if (!this.currentUser) {
      this.http.get<User>(this.currentUserUrl).subscribe(
        user => {
          this.currentUser = user;
        },
        error => {
          console.log(error);
          throw error;
        }
      );
    }
  }


  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }

  getRoles(): Observable<string[]> {
    return this.http.get<string[]>(this.rolesUrl);
  }

  getCurrentUser(): User {
    return this.currentUser;
  }

  getUser(id: number): Observable<User> {
    return this.http.get<User>(this.usersByIdUrl + id);
  }

  saveUser(user: User): Observable<User> {
    return this.http.post<User>(this.saveUserUrl, user)
  }

  changePassword(user: User): Observable<User> {
    return this.http.post<User>(this.changePasswordUrl, user)
  }
}
