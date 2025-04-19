import { useEffect, useState } from "react";
import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  Tooltip,
  CartesianGrid,
  ResponsiveContainer,
  Label,
} from "recharts";
import { getAllProgress } from "../services/api";

interface Record {
  exerciseName: string;
  weight: number;
  date: string;
}

const WeightTrendChart = () => {
  const [allRecords, setAllRecords] = useState<Record[]>([]);
  const [exerciseList, setExerciseList] = useState<string[]>([]);
  const [selectedExercise, setSelectedExercise] = useState<string>("");
  const [chartData, setChartData] = useState<any[]>([]);

  useEffect(() => {
    getAllProgress().then((records: Record[]) => {
      setAllRecords(records);

      const uniqueExercises = Array.from(
        new Set(records.map((r) => r.exerciseName))
      );
      setExerciseList(uniqueExercises);

      if (uniqueExercises.length > 0) {
        setSelectedExercise(uniqueExercises[0]);
      }
    });
  }, []);

  useEffect(() => {
    if (!selectedExercise) return;

    const filtered = allRecords
      .filter((r) => r.exerciseName === selectedExercise)
      .sort(
        (a, b) =>
          new Date(a.date).getTime() - new Date(b.date).getTime()
      );

    if (filtered.length === 0) return;

    const baseWeight = filtered[0].weight;

    const data = filtered.map((r) => ({
      date: r.date,
      weight: r.weight,
      percent: Number(
        (((r.weight - baseWeight) / baseWeight) * 100).toFixed(2)
      ),
    }));

    setChartData(data);
  }, [selectedExercise, allRecords]);

  return (
    <div>
      <h2>Progress Trend for {selectedExercise}</h2>

      <select
        value={selectedExercise}
        onChange={(e) => setSelectedExercise(e.target.value)}
        style={{ padding: "8px", marginBottom: "16px" }}
      >
        {exerciseList.map((ex) => (
          <option key={ex} value={ex}>
            {ex}
          </option>
        ))}
      </select>

      <ResponsiveContainer width="100%" height={300}>
        <LineChart data={chartData}>
          <XAxis dataKey="date" />
          <YAxis>
            <Label value="% ↑" angle={-90} position="insideLeft" />
          </YAxis>
          <Tooltip />
          <CartesianGrid stroke="#eee" strokeDasharray="5 5" />
          <Line
            type="monotone"
            dataKey="percent"
            stroke="#82ca9d"
            dot={true}
/>

        </LineChart>
      </ResponsiveContainer>
    </div>
  );
};

export default WeightTrendChart;
