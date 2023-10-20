# Car Wash Simulation

A program in Java to simulate and report the wait times of a car wash’s business with standard and upgraded equipment.  
Created for the [Project #2 Car Wash Simulation](https://www.cs.kzoo.edu/cs210/projects/Queues/CarWashProgram.html) at [Kalamazoo College](https://www.kzoo.edu/).

## Objectives

- Simulate days of business at both 3 and 4 minutes per wash.
- Track how long cars have been waiting for their wash.
- Track how many cars have been waiting longer than 10 minutes.
- Report these data for both base equipment (4 min/wash) and upgraded equipment (3 min/wash).

## Assumptions

- Events, such as car arrivals and washing, happen every minute.
- The car wash is open for 10 hours / 600 minutes.
- Every minute, cars have a 1 in 4 chance of arriving at the car wash.
- The simulation will not end until cars waiting in line are washed, but cars cannot arrive after closing.

## Results

An `output.csv` as a table created by the `CarWashApplication` main method:
| Day     | Base Average Wait | Base # Cars With Long Wait | Upgraded Average Wait | Upgraded # Cars With Long Wait |
| ------- | ----------------- | -------------------------- | --------------------- | ------------------------------ |
| 1       | 14.64             | 98                         | 2.46                  | 4                              |
| 2       | 10.02             | 51                         | 1.78                  | 0                              |
| 3       | 8.58              | 62                         | 3.26                  | 2                              |
| 4       | 4.36              | 15                         | 2.43                  | 7                              |
| 5       | 13.70             | 69                         | 2.20                  | 3                              |
| 6       | 22.51             | 131                        | 2.70                  | 12                             |
| 7       | 27.44             | 129                        | 1.76                  | 3                              |
| **Average** | **14.46**             | **79.29**                      | **2.37**                  | **4.43**                           |

The following is an example console output from the `CarWashApplication` main method:

```
===================================
TRIAL 1: 4 minutes per wash
===================================

--- Day 1 Simulation (4 minutes per wash) ---
Simulation complete. Time elapsed: 635 minutes.
Cars washed: 155.
Total wait time: 2269 minutes.
Average wait time: 14.64 minutes.
Cars that waited at least 10 minutes: 98.

--- Day 2 Simulation (4 minutes per wash) ---
Simulation complete. Time elapsed: 612 minutes.
Cars washed: 140.
Total wait time: 1403 minutes.
Average wait time: 10.02 minutes.
Cars that waited at least 10 minutes: 51.

--- Day 3 Simulation (4 minutes per wash) ---
Simulation complete. Time elapsed: 614 minutes.
Cars washed: 148.
Total wait time: 1270 minutes.
Average wait time: 8.58 minutes.
Cars that waited at least 10 minutes: 62.

--- Day 4 Simulation (4 minutes per wash) ---
Simulation complete. Time elapsed: 606 minutes.
Cars washed: 129.
Total wait time: 562 minutes.
Average wait time: 4.36 minutes.
Cars that waited at least 10 minutes: 15.

--- Day 5 Simulation (4 minutes per wash) ---
Simulation complete. Time elapsed: 643 minutes.
Cars washed: 151.
Total wait time: 2069 minutes.
Average wait time: 13.70 minutes.
Cars that waited at least 10 minutes: 69.

--- Day 6 Simulation (4 minutes per wash) ---
Simulation complete. Time elapsed: 637 minutes.
Cars washed: 158.
Total wait time: 3556 minutes.
Average wait time: 22.51 minutes.
Cars that waited at least 10 minutes: 131.

--- Day 7 Simulation (4 minutes per wash) ---
Simulation complete. Time elapsed: 632 minutes.
Cars washed: 154.
Total wait time: 4226 minutes.
Average wait time: 27.44 minutes.
Cars that waited at least 10 minutes: 129.

===================================
TRIAL 2: 3 minutes per wash.
===================================

--- Day 1 Simulation (3 minutes per wash) ---
Simulation complete. Time elapsed: 603 minutes.
Cars washed: 141.
Total wait time: 347 minutes.
Average wait time: 2.46 minutes.
Cars that waited at least 10 minutes: 4.

--- Day 2 Simulation (3 minutes per wash) ---
Simulation complete. Time elapsed: 602 minutes.
Cars washed: 141.
Total wait time: 251 minutes.
Average wait time: 1.78 minutes.
Cars that waited at least 10 minutes: 0.

--- Day 3 Simulation (3 minutes per wash) ---
Simulation complete. Time elapsed: 602 minutes.
Cars washed: 165.
Total wait time: 538 minutes.
Average wait time: 3.26 minutes.
Cars that waited at least 10 minutes: 2.

--- Day 4 Simulation (3 minutes per wash) ---
Simulation complete. Time elapsed: 601 minutes.
Cars washed: 129.
Total wait time: 313 minutes.
Average wait time: 2.43 minutes.
Cars that waited at least 10 minutes: 7.

--- Day 5 Simulation (3 minutes per wash) ---
Simulation complete. Time elapsed: 601 minutes.
Cars washed: 138.
Total wait time: 303 minutes.
Average wait time: 2.20 minutes.
Cars that waited at least 10 minutes: 3.

--- Day 6 Simulation (3 minutes per wash) ---
Simulation complete. Time elapsed: 602 minutes.
Cars washed: 145.
Total wait time: 392 minutes.
Average wait time: 2.70 minutes.
Cars that waited at least 10 minutes: 12.

--- Day 7 Simulation (3 minutes per wash) ---
Simulation complete. Time elapsed: 606 minutes.
Cars washed: 149.
Total wait time: 262 minutes.
Average wait time: 1.76 minutes.
Cars that waited at least 10 minutes: 3.
```
