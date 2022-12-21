import { Address } from "./address"
import { Menu } from "./menu"

export class Restaurant {
    id: number | undefined
    name: string
    address: string
    openingTime: Date
    closingTime: Date
    open: boolean
    menu!: Menu

    constructor(name: string, address: string, openingTime: Date, closingTime: Date, open: boolean, menu: Menu){
        this.name = name
        this.address = address
        this.openingTime = openingTime
        this.closingTime = closingTime
        this.open = open
        menu = menu
    }

}
