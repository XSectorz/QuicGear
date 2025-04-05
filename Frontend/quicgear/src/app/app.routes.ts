import { Routes } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { CreateUserComponent } from './create-user/create-user.component';

export const routes: Routes = [

    {
        path: "users", component: UserListComponent
    },
    {
        path: "create-user", component: CreateUserComponent
    },
    {
        path: "", redirectTo: 'users', pathMatch: 'full'
    }

];
