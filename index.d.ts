type GetItemCallback = (value: string | null) => void;
type GetMultipleItemsCallback = (values: string[] | null) => void;

declare module "react-native-shared-preferences" {
    const setName: (name: string) => void;
    const setItem: (key: string , value: string) => void;
    const getItem: (key: string, callback: GetItemCallback) => void;
    const getItems: (keys: string[], callback: GetMultipleItemsCallback) => void;
    const getAll: (callback: GetMultipleItemsCallback) => void;
    const clear: () => void;
    const getAllKeys: (callback: GetMultipleItemsCallback) => void;
    const removeItem: (key: string) => void;
}
