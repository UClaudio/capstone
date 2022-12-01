export class Role {
    id: number | undefined
    roleType: string

    constructor(roleType: string) {
        this.roleType = roleType
    }
}
