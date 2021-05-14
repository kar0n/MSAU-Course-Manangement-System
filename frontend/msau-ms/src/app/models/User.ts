export interface User {
    provider : string;
    userId : number;
    name : string;
    type : string;
    email : string;
    location : string;
    designation : string;
    image : string;
    createdOn : Date;
    modifiedOn : Date;
    token?: string

}