import { Role } from "./role"

export class User {
    id: number | undefined
    username: string
    password: string
    fullName: string
    email: string
    roles: Role[]
    active: boolean

    constructor(username: string, password: string, active: boolean, fullName: string, email: string, roles: Role[], ) {
        this.username = username
        this.password = password
        this.active = active
        this.fullName = fullName
        this.email = email
        this.roles = roles
    }

}
