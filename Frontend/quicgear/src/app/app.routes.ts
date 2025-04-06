import { Routes } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { ContentComponent } from './content/content.component';

export const routes: Routes = [

    {
        path: "users", component: UserListComponent
    },
    {
        path: "create-user", component: CreateUserComponent
    },
    {
        path: "", component: ContentComponent
    }
   /* {
        path: "", redirectTo: 'users', pathMatch: 'full'
    }*/

];
