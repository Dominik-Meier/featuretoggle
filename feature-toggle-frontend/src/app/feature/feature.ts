export class Feature {
    id: string;
    version: number;
    displayName?: string;
    technicalName?: string;
    description?: string;
    inverted: boolean;
    customerIds: string[];
    expiresOn?: Date;
}