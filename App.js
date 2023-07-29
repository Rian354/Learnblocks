import { AiOutlineDelete } from 'react-icons/ai';
import * as React from 'react';
import dayjs from 'dayjs';
import './App.css';
import { DemoContainer, DemoItem } from '@mui/x-date-pickers/internals/demo';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { DateTimePicker } from '@mui/x-date-pickers/DateTimePicker';
import { StaticDateTimePicker } from '@mui/x-date-pickers/StaticDateTimePicker';
import { useState } from 'react';

function ResponsiveDateTimePickers() {
  const [date, setDate] = useState(dayjs('2023-06-20T15:30'));
  const [dateArr, setDateArr] = useState([]);
  const [description, setDescription] = useState("");

  const handleDeleteDate = (index) => {
    const updatedDateArr = [...dateArr];
    updatedDateArr.splice(index, 1);
    setDateArr(updatedDateArr);
  };

  const handleFinalize = () => {
    const formattedDate = date.format('dddd, MMMM D, YYYY h:mm A');
    const newItem = { date: formattedDate, description: description };
    setDateArr([...dateArr, newItem]);
    setDescription("");
  };

  return (
    <>
      <div className="Timepicker">
        <LocalizationProvider dateAdapter={AdapterDayjs}>
          <DemoContainer
            components={[
              'DateTimePicker',
              'MobileDateTimePicker',
              'DesktopDateTimePicker',
              'StaticDateTimePicker',
            ]}
          >
            <DemoItem>
              <StaticDateTimePicker
                value={date}
                defaultValue={dayjs('2023-06-20T15:30')}
                minutesStep={30}
                onChange={(newdate) => setDate(newdate)}
              />
            </DemoItem>
          </DemoContainer>
        </LocalizationProvider>
        <input
          type="text"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          placeholder="Enter description"
        />
        <button onClick={handleFinalize}>Finalize</button>
      </div>

      <div className="DateShow">
        {dateArr.map((item, index) => (
          <div key={index} className="DateElement">
            <span>{item.date}</span>
            <span>{item.description}</span>
            <button onClick={() => handleDeleteDate(index)}>
              <AiOutlineDelete />
            </button>
          </div>
        ))}
      </div>
    </>
  );
}

function App() {
  return (
    <>
      <ResponsiveDateTimePickers />
    </>
  );
}

export default App;
