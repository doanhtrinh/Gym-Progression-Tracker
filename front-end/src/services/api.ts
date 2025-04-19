import axios from "axios";

const API_URL = "http://localhost:8080/api/v1/gymprogress";

export const getAllProgress = async () => {
    const response = await axios.get(API_URL);
    return response.data;
};

export const addProgress = async (progress: any) => {
    await axios.post(API_URL, progress);
};

export const deleteProgress = async (id: number) => {
    await axios.delete(`${API_URL}/${id}`);
};

export const updateProgress = async (id: number, progress: any) => {
    await axios.put(`${API_URL}/${id}`, progress);
};
