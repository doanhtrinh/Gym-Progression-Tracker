import { useEffect, useState } from "react";
import { getAllProgress, deleteProgress } from "../services/api";

const GymProgressList = () => {
    const [progress, setProgress] = useState([]);

    useEffect(() => {
        getAllProgress().then(setProgress);
    }, []);

    const handleDelete = async (id: number) => {
        await deleteProgress(id);
        setProgress(progress.filter((p: any) => p.id !== id));
    };

    return (
        <div>
            <h2>Gym Progress Records</h2>
            <ul>
                {progress.map((p: any) => (
                    <li key={p.id}>
                        {p.name} - {p.exerciseName} ({p.weight} kg, {p.reps} reps)  
                        <button onClick={() => handleDelete(p.id)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default GymProgressList;
