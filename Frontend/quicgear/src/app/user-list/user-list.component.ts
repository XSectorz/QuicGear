import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { User } from '../user'
import { UserService } from '../user.service';


@Component({
  selector: 'app-user-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './user-list.component.html',
  styleUrl: './user-list.component.css'
})

export class UserListComponent {
  users: User[] = [];

  constructor(private userService: UserService) {}

  ngOnInit(): void {

   /* this.users = [
      { "id": 1, "userRole": "USER", "firstName": 'Alice', "lastName": 'Smith', "emailID": 'alice@example.com' }
    ];*/

    this.getUsers();

  }

  private getUsers() {
    this.userService.getUserList().subscribe(
      (data) => {
        //console.log(data);
        this.users = data;
      },
      (error) => {
        console.error('Error loading users:', error);
      }
    );
  }

}
