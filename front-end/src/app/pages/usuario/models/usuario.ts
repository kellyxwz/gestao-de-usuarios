export interface Usuario {
    id: number;
    name: string; 
    email: string;
    role: "USER" | "ADMIN";
    activo: boolean;
}
