import { Role } from "./role"

export class User {
    id: number | undefined
    username: string
    password: string
    fullName: string
    email: string
    roles: Role[]

    constructor(username: string, password: string, fullName: string, email: string, roles: Role[]){
        this.username = username
        this.password = password
        this.fullName = fullName
        this.email = email
        this.roles = roles
    }

}
