import { Component } from '@angular/core';
import { AxiosService } from '../axios.service';
import { LoginComponent } from '../login/login.component';
import { CommonModule } from '@angular/common';
import { User } from '../model/user';
import { StateService } from '../state.service';

@Component({
  selector: 'app-content',
  imports: [LoginComponent,CommonModule],
  templateUrl: './content.component.html',
  styleUrl: './content.component.css'
})
export class ContentComponent {

  constructor(private axiosService: AxiosService, public appStateService: StateService) {}

  user!: User;
/*
  ngOnInit(): void {
    this.appStateService.componentToShow$.subscribe((component) => {
      console.log("Component to show in ContentComponent: ", component);
    });
  }*/

  showComponent(componentToShow: string): void {
    this.appStateService.setComponentToShow(componentToShow);
  }

  onLogin(input: any): void {
    this.axiosService.request(
      "POST",
      "/login",
      {
        username: input.username,
        password: input.password
      }
    ).then(response => {

      this.user = {
        id: response.data.id,
        username: response.data.username,
        balance: response.data.balance,
        userRole: response.data.userRole,
        email: response.data.email
      }

      this.axiosService.setAuthToken(response.data.token);
      this.showComponent("main");
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
    ).then(response => {
      this.axiosService.setAuthToken(response.data.token);
      this.showComponent("main");
    })
  }

}
