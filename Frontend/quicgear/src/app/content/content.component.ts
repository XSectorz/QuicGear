import { Component } from '@angular/core';
import { AxiosService } from '../axios.service';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-content',
  imports: [LoginComponent],
  templateUrl: './content.component.html',
  styleUrl: './content.component.css'
})
export class ContentComponent {

  constructor(private axiosService: AxiosService) {}

  onLogin(input: any): void {
    this.axiosService.request(
      "POST",
      "/login",
      {
        username: input.username,
        password: input.password
      }
    )

    console.log(      {
      username: input.username,
      password: input.password
    })



  }

  onRegister(input: any): void {
    this.axiosService.request(
      "POST",
      "/register",
      {
        username: input.username,
        password: input.password,
        email: input.email
      }
    )

    console.log(      {
      username: input.username,
      password: input.password,
      email: input.email
    })
  }

}
