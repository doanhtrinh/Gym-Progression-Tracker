// src/components/AddProgressForm.tsx
import { useState } from "react";
import { addProgress } from "../services/api";

const AddProgressForm = () => {
  const [formData, setFormData] = useState({
    name: "",
    dob: "",
    email: "",
    exerciseName: "",
    weight: "",
    reps: "",
    date: ""
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await addProgress(formData);
      alert("Progress added!");
      window.location.reload(); // reload to update the chart
    } catch (err) {
      alert("Error adding progress. Check the console.");
      console.error(err);
    }
  };

  return (
    <form onSubmit={handleSubmit} style={{ marginBottom: "2rem" }}>
      <input name="name" placeholder="Name" onChange={handleChange} required />
      <input type="date" name="dob" onChange={handleChange} required />
      <input name="email" placeholder="Email" onChange={handleChange} required />
      <input name="exerciseName" placeholder="Exercise" onChange={handleChange} required />
      <input type="number" name="weight" placeholder="Weight (kg)" onChange={handleChange} required />
      <input type="number" name="reps" placeholder="Reps" onChange={handleChange} required />
      <input type="date" name="date" onChange={handleChange} required />
      <button type="submit">Add Progress</button>
    </form>
  );
};

export default AddProgressForm;
