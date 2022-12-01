import { Address } from "./address"
import { Menu } from "./menu"

export class Restaurant {
    id: number | undefined
    name: string
    address: Address
    openingTime: Date
    closingTime: Date
    open: boolean
    menus!: Menu[]

    constructor(name: string, address: Address, openingTime: Date, closingTime: Date, open: boolean, menus: Menu[]){
        this.name = name
        this.address = address
        this.openingTime = openingTime
        this.closingTime = closingTime
        this.open = open
        menus = menus
    }

}
