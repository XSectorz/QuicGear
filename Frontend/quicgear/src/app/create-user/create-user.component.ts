import { Component } from '@angular/core';
import { User } from '../model/user';
import { FormsModule } from '@angular/forms'
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-user',
  imports: [FormsModule],
  templateUrl: './create-user.component.html',
  styleUrl: './create-user.component.css'
})
export class CreateUserComponent {

  user: User = new User();

  constructor(private userService: UserService,private router: Router) {}


  saveUser() {
    this.userService.createUser(this.user).subscribe(data => {
      console.log(data);
      this.goToUserList();
    }, error => console.log(error))
  }

  goToUserList() {
    this.router.navigate(['/users']);
  }

  onSubmit() {
    this.saveUser();
  }

}
