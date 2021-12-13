import serial
import time

arduinoData = serial.Serial('COM3', 9600);
time.sleep(2)

while 1:
    incoming = arduinoData.readline();

    decodedData = incoming.decode()
    distance = decodedData.rstrip()

    print(distance)
