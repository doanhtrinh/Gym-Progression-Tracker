import AddProgressForm from "./components/AddProgressForm";
import WeightTrendChart from "./components/WeightTrendChart";

function App() {
  return (
    <div style={{ padding: "2rem" }}>
      <h1>🏋️ Gym Progress Tracker</h1>
      <AddProgressForm />
      <WeightTrendChart />
    </div>
  );
}

export default App;
