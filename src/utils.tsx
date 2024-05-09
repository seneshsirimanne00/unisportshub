export function getFormattedTime(datetime: Date): string | null {
  try {
    const hours = datetime.getHours() % 12;  // Handle hours for 12-hour format
    const minutes = datetime.getMinutes();
    const amPm = hours < 12 ? "AM" : "PM";
    const formattedTime = `${hours}.${minutes.toString().padStart(2, '0')} ${amPm}`; // Format minutes with leading zero
    return formattedTime;
  } catch (error) {
    console.error("Invalid date object provided.");
    return null;
  }
}