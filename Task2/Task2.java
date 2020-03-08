import java.io.*;
import java.util.*;

public class Task2 {
    public static void main(String[] args) throws Exception {
        double arr1[][] = new double[4][2];
        double arr2[][] = new double[100][2];
        arr1 = readFile(args[0]);
        arr2 = readFile(args[1]);
        arr1 = highRight(arr1);
        attachment(arr1, arr2);
    }
    static double [][] readFile (String filename) throws Exception {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String data = "";
            int counter = 0;
            double input1[][] = new double[100][2];
            while ((data = in.readLine()) != null) {
                String sp[] = data.split(" ");
                input1[counter][0] = Double.parseDouble(sp[0]);
                input1[counter][1] = Double.parseDouble(sp[1]);
                counter++;
            }
            double input [][] = new double [counter][2];
            for (int i = 0; i < counter; i++) {
                for (int j = 0; j < 2; j++) {
                    input[i][j] = input1[i][j];
                }
            }
            return input;
    }
    static double lineScreener (double x1, double x2, double x, double y1, double y2, double y) {
        double result = y - x * (y2 - y1) / (x2 - x1) + (x1 * y2 - x2 * y1) / (x2 - x1);
        return result;
    }
    static double lineSign (double x1, double x2, double y1, double y2) {
        double result = (y2 - y1)/(x2 - x1);
        return result;
    }
    static void attachment (double arr1[][], double arr2[][]) {
        for (int i = 0; i < arr2.length; i++) {
            if (arr1[0][0] - arr1[1][0] == 0) {
                if (arr2[i][0] == arr1[0][0]) {
                    if (arr2[i][1] < arr1[0][1] && arr2[i][1] > arr1[1][1]) {
                        System.out.println("1");
                    } else {
                        System.out.println("3");
                    }
                } else if (arr2[i][0] - arr1[0][0] > 0) {
                    System.out.println("3");
                } else {
                    if (arr1[2][1] == arr1[1][1]) {
                        if (arr2[i][1] == arr1[1][1]) {
                            if (arr2[i][0] > arr1[2][1] && arr2[i][0] < arr1[1][1]) {
                                System.out.println("1");
                            } else {
                                System.out.println("3");
                            }
                        } else if (arr2[i][1] - arr1[1][1] < 0) {
                            System.out.println("3");
                        } else {
                            if (arr1[3][0] == arr1[2][0]) {
                                if (arr2[i][0] == arr2[2][0]) {
                                    if (arr2[i][1] < arr1[3][1] && arr2[i][1] > arr1[2][1]) {
                                        System.out.println("1");
                                    } else {
                                        System.out.println("3");
                                    }
                                } else if (arr2[i][0] < arr2[2][0]) {
                                    System.out.println("3");
                                } else {
                                    if (arr1[3][1] == arr1[0][1]) {
                                        if (arr2[i][1] == arr1[3][1]) {
                                            if (arr2[i][0] > arr1[3][1] && arr2[i][0] < arr1[0][1]) {
                                                System.out.println("1");
                                            } else {
                                                System.out.println("3");
                                            }
                                        } else if (arr2[i][1] - arr1[3][1] > 0) {
                                            System.out.println("3");
                                        } else {
                                            System.out.println("2");
                                        }
                                    } else {
                                        if (lineScreener(arr1[3][0], arr1[0][0], arr2[i][0], arr1[3][1], arr1[0][1], arr2[i][1]) < 0) {
                                            System.out.println("2");
                                        } else if (lineScreener(arr1[3][0], arr1[0][0], arr2[i][0], arr1[3][1], arr1[0][1], arr2[i][1]) == 0) {
                                            if (arr2[i][0] < arr1[0][0] && arr2[i][0] > arr1[3][0] || arr2[i][0] > arr1[0][0] && arr2[i][0] < arr1[3][0]) {
                                                System.out.println("2");
                                            }
                                        } else {
                                            System.out.println("3");
                                        }
                                    }
                                }
                            } else {
                                if (lineScreener(arr1[2][0], arr1[3][0], arr2[i][0], arr1[2][1], arr1[3][1], arr2[i][1]) * lineSign(arr1[2][0], arr1[3][0], arr1[2][1], arr1[3][1]) < 0) {
                                    if (arr1[3][1] == arr1[0][1]) {
                                        if (arr2[i][1] == arr1[3][1]) {
                                            if (arr2[i][0] > arr1[3][1] && arr2[i][0] < arr1[0][1]) {
                                                System.out.println("1");
                                            } else {
                                                System.out.println("3");
                                            }
                                        } else if (arr2[i][1] - arr1[3][1] > 0) {
                                            System.out.println("3");
                                        } else {
                                            System.out.println("2");
                                        }
                                    } else {
                                        if (lineScreener(arr1[3][0], arr1[0][0], arr2[i][0], arr1[3][1], arr1[0][1], arr2[i][1]) < 0) {
                                            System.out.println("2");
                                        } else if (lineScreener(arr1[3][0], arr1[0][0], arr2[i][0], arr1[3][1], arr1[0][1], arr2[i][1]) == 0) {
                                            if (arr2[i][0] < arr1[0][0] && arr2[i][0] > arr1[3][0] || arr2[i][0] > arr1[0][0] && arr2[i][0] < arr1[3][0]) {
                                                System.out.println("2");
                                            }
                                        } else {
                                            System.out.println("3");
                                        }
                                    }
                                } else if (lineScreener(arr1[2][0], arr1[3][0], arr2[i][0], arr1[2][1], arr1[3][1], arr2[i][1]) == 0) {
                                    if (arr2[i][1] < arr1[2][1] && arr2[i][1] > arr1[3][1] || arr2[i][1] > arr1[2][1] && arr2[i][1] < arr1[3][1]) {
                                        System.out.println("1");
                                    }
                                } else {
                                    System.out.println("3");
                                }
                            }
                        }
                    } else {
                        if (lineScreener(arr1[2][0], arr1[1][0], arr2[i][0], arr1[2][1], arr1[1][1], arr2[i][1]) > 0) {
                            if (arr1[3][0] == arr1[2][0]) {
                                if (arr2[i][0] == arr2[2][0]) {
                                    if (arr2[i][1] < arr1[3][1] && arr2[i][1] > arr1[2][1]) {
                                        System.out.println("1");
                                    } else {
                                        System.out.println("3");
                                    }
                                } else if (arr2[i][0] < arr2[2][0]) {
                                    System.out.println("3");
                                } else {
                                    if (arr1[3][1] == arr1[0][1]) {
                                        if (arr2[i][1] == arr1[3][1]) {
                                            if (arr2[i][0] > arr1[3][1] && arr2[i][0] < arr1[0][1]) {
                                                System.out.println("1");
                                            } else {
                                                System.out.println("3");
                                            }
                                        } else if (arr2[i][1] - arr1[3][1] > 0) {
                                            System.out.println("3");
                                        } else {
                                            System.out.println("2");
                                        }
                                    } else {
                                        if (lineScreener(arr1[3][0], arr1[0][0], arr2[i][0], arr1[3][1], arr1[0][1], arr2[i][1]) < 0) {
                                            System.out.println("2");
                                        } else if (lineScreener(arr1[3][0], arr1[0][0], arr2[i][0], arr1[3][1], arr1[0][1], arr2[i][1]) == 0) {
                                            if (arr2[i][0] < arr1[0][0] && arr2[i][0] > arr1[3][0] || arr2[i][0] > arr1[0][0] && arr2[i][0] < arr1[3][0]) {
                                                System.out.println("2");
                                            }
                                        } else {
                                            System.out.println("3");
                                        }
                                    }
                                }
                            } else {
                                if (lineScreener(arr1[2][0], arr1[3][0], arr2[i][0], arr1[2][1], arr1[3][1], arr2[i][1]) * lineSign(arr1[2][0], arr1[3][0], arr1[2][1], arr1[3][1]) < 0) {
                                    if (arr1[3][1] == arr1[0][1]) {
                                        if (arr2[i][1] == arr1[3][1]) {
                                            if (arr2[i][0] > arr1[3][1] && arr2[i][0] < arr1[0][1]) {
                                                System.out.println("1");
                                            } else {
                                                System.out.println("3");
                                            }
                                        } else if (arr2[i][1] - arr1[3][1] > 0) {
                                            System.out.println("3");
                                        } else {
                                            System.out.println("2");
                                        }
                                    } else {
                                        if (lineScreener(arr1[3][0], arr1[0][0], arr2[i][0], arr1[3][1], arr1[0][1], arr2[i][1]) < 0) {
                                            System.out.println("2");
                                        } else if (lineScreener(arr1[3][0], arr1[0][0], arr2[i][0], arr1[3][1], arr1[0][1], arr2[i][1]) == 0) {
                                            if (arr2[i][0] < arr1[0][0] && arr2[i][0] > arr1[3][0] || arr2[i][0] > arr1[0][0] && arr2[i][0] < arr1[3][0]) {
                                                System.out.println("2");
                                            }
                                        } else {
                                            System.out.println("3");
                                        }
                                    }
                                } else if (lineScreener(arr1[2][0], arr1[3][0], arr2[i][0], arr1[2][1], arr1[3][1], arr2[i][1]) == 0) {
                                    if (arr2[i][1] < arr1[2][1] && arr2[i][1] > arr1[3][1] || arr2[i][1] > arr1[2][1] && arr2[i][1] < arr1[3][1]) {
                                        System.out.println("1");
                                    }
                                } else {
                                    System.out.println("3");
                                }
                            }
                        } else if (lineScreener(arr1[2][0], arr1[1][0], arr2[i][0], arr1[2][1], arr1[1][1], arr2[i][1]) == 0) {
                            if (arr2[i][0] < arr1[1][0] && arr2[i][0] > arr1[2][0] && arr2[i][0] > arr1[1][0] && arr2[i][0] < arr1[2][0]) {
                                System.out.println("1");
                            }
                        } else {
                            System.out.println("3");
                        }
                    }
                }
            } else {
                if (lineScreener(arr1[1][0], arr1[0][0], arr2[i][0], arr1[1][1], arr1[0][1], arr2[i][1]) * lineSign(arr1[1][0], arr1[0][0], arr1[1][1], arr1[0][1]) > 0) {
                    if (arr1[2][1] == arr1[1][1]) {
                        if (arr2[i][1] == arr1[1][1]) {
                            if (arr2[i][0] > arr1[2][1] && arr2[i][0] < arr1[1][1]) {
                                System.out.println("1");
                            } else {
                                System.out.println("3");
                            }
                        } else if (arr2[i][1] - arr1[1][1] < 0) {
                            System.out.println("3");
                        } else {
                            if (arr1[3][0] == arr1[2][0]) {
                                if (arr2[i][0] == arr2[2][0]) {
                                    if (arr2[i][1] < arr1[3][1] && arr2[i][1] > arr1[2][1]) {
                                        System.out.println("1");
                                    } else {
                                        System.out.println("3");
                                    }
                                } else if (arr2[i][0] < arr2[2][0]) {
                                    System.out.println("3");
                                } else {
                                    if (arr1[3][1] == arr1[0][1]) {
                                        if (arr2[i][1] == arr1[3][1]) {
                                            if (arr2[i][0] > arr1[3][1] && arr2[i][0] < arr1[0][1]) {
                                                System.out.println("1");
                                            } else {
                                                System.out.println("3");
                                            }
                                        } else if (arr2[i][1] - arr1[3][1] > 0) {
                                            System.out.println("3");
                                        } else {
                                            System.out.println("2");
                                        }
                                    } else {
                                        if (lineScreener(arr1[3][0], arr1[0][0], arr2[i][0], arr1[3][1], arr1[0][1], arr2[i][1]) < 0) {
                                            System.out.println("2");
                                        } else if (lineScreener(arr1[3][0], arr1[0][0], arr2[i][0], arr1[3][1], arr1[0][1], arr2[i][1]) == 0) {
                                            if (arr2[i][0] < arr1[0][0] && arr2[i][0] > arr1[3][0] || arr2[i][0] > arr1[0][0] && arr2[i][0] < arr1[3][0]) {
                                                System.out.println("2");
                                            }
                                        } else {
                                            System.out.println("3");
                                        }
                                    }
                                }
                            } else {
                                if (lineScreener(arr1[2][0], arr1[3][0], arr2[i][0], arr1[2][1], arr1[3][1], arr2[i][1]) * lineSign(arr1[2][0], arr1[3][0], arr1[2][1], arr1[3][1]) < 0) {
                                    if (arr1[3][1] == arr1[0][1]) {
                                        if (arr2[i][1] == arr1[3][1]) {
                                            if (arr2[i][0] > arr1[3][1] && arr2[i][0] < arr1[0][1]) {
                                                System.out.println("1");
                                            } else {
                                                System.out.println("3");
                                            }
                                        } else if (arr2[i][1] - arr1[3][1] > 0) {
                                            System.out.println("3");
                                        } else {
                                            System.out.println("2");
                                        }
                                    } else {
                                        if (lineScreener(arr1[3][0], arr1[0][0], arr2[i][0], arr1[3][1], arr1[0][1], arr2[i][1]) < 0) {
                                            System.out.println("2");
                                        } else if (lineScreener(arr1[3][0], arr1[0][0], arr2[i][0], arr1[3][1], arr1[0][1], arr2[i][1]) == 0) {
                                            if (arr2[i][0] < arr1[0][0] && arr2[i][0] > arr1[3][0] || arr2[i][0] > arr1[0][0] && arr2[i][0] < arr1[3][0]) {
                                                System.out.println("2");
                                            }
                                        } else {
                                            System.out.println("3");
                                        }
                                    }
                                } else if (lineScreener(arr1[2][0], arr1[3][0], arr2[i][0], arr1[2][1], arr1[3][1], arr2[i][1]) == 0) {
                                    if (arr2[i][1] < arr1[2][1] && arr2[i][1] > arr1[3][1] || arr2[i][1] > arr1[2][1] && arr2[i][1] < arr1[3][1]) {
                                        System.out.println("1");
                                    }
                                } else {
                                    System.out.println("3");
                                }
                            }
                        }
                    } else {
                        if (lineScreener(arr1[2][0], arr1[1][0], arr2[i][0], arr1[2][1], arr1[1][1], arr2[i][1]) > 0) {
                            if (arr1[3][0] == arr1[2][0]) {
                                if (arr2[i][0] == arr2[2][0]) {
                                    if (arr2[i][1] < arr1[3][1] && arr2[i][1] > arr1[2][1]) {
                                        System.out.println("1");
                                    } else {
                                        System.out.println("3");
                                    }
                                } else if (arr2[i][0] < arr2[2][0]) {
                                    System.out.println("3");
                                } else {
                                    if (arr1[3][1] == arr1[0][1]) {
                                        if (arr2[i][1] == arr1[3][1]) {
                                            if (arr2[i][0] > arr1[3][1] && arr2[i][0] < arr1[0][1]) {
                                                System.out.println("1");
                                            } else {
                                                System.out.println("3");
                                            }
                                        } else if (arr2[i][1] - arr1[3][1] > 0) {
                                            System.out.println("3");
                                        } else {
                                            System.out.println("2");
                                        }
                                    } else {
                                        if (lineScreener(arr1[3][0], arr1[0][0], arr2[i][0], arr1[3][1], arr1[0][1], arr2[i][1]) < 0) {
                                            System.out.println("2");
                                        } else if (lineScreener(arr1[3][0], arr1[0][0], arr2[i][0], arr1[3][1], arr1[0][1], arr2[i][1]) == 0) {
                                            if (arr2[i][0] < arr1[0][0] && arr2[i][0] > arr1[3][0] || arr2[i][0] > arr1[0][0] && arr2[i][0] < arr1[3][0]) {
                                                System.out.println("2");
                                            }
                                        } else {
                                            System.out.println("3");
                                        }
                                    }
                                }
                            } else {
                                if (lineScreener(arr1[2][0], arr1[3][0], arr2[i][0], arr1[2][1], arr1[3][1], arr2[i][1]) * lineSign(arr1[2][0], arr1[3][0], arr1[2][1], arr1[3][1]) < 0) {
                                    if (arr1[3][1] == arr1[0][1]) {
                                        if (arr2[i][1] == arr1[3][1]) {
                                            if (arr2[i][0] > arr1[3][1] && arr2[i][0] < arr1[0][1]) {
                                                System.out.println("1");
                                            } else {
                                                System.out.println("3");
                                            }
                                        } else if (arr2[i][1] - arr1[3][1] > 0) {
                                            System.out.println("3");
                                        } else {
                                            System.out.println("2");
                                        }
                                    } else {
                                        if (lineScreener(arr1[3][0], arr1[0][0], arr2[i][0], arr1[3][1], arr1[0][1], arr2[i][1]) < 0) {
                                            System.out.println("2");
                                        } else if (lineScreener(arr1[3][0], arr1[0][0], arr2[i][0], arr1[3][1], arr1[0][1], arr2[i][1]) == 0) {
                                            if (arr2[i][0] < arr1[0][0] && arr2[i][0] > arr1[3][0] || arr2[i][0] > arr1[0][0] && arr2[i][0] < arr1[3][0]) {
                                                System.out.println("2");
                                            }
                                        } else {
                                            System.out.println("3");
                                        }
                                    }
                                } else if (lineScreener(arr1[2][0], arr1[3][0], arr2[i][0], arr1[2][1], arr1[3][1], arr2[i][1]) == 0) {
                                    if (arr2[i][1] < arr1[2][1] && arr2[i][1] > arr1[3][1] || arr2[i][1] > arr1[2][1] && arr2[i][1] < arr1[3][1]) {
                                        System.out.println("1");
                                    }
                                } else {
                                    System.out.println("3");
                                }
                            }
                        } else if (lineScreener(arr1[2][0], arr1[1][0], arr2[i][0], arr1[2][1], arr1[1][1], arr2[i][1]) == 0) {
                            if (arr2[i][0] < arr1[1][0] && arr2[i][0] > arr1[2][0] && arr2[i][0] > arr1[1][0] && arr2[i][0] < arr1[2][0]) {
                                System.out.println("1");
                            }
                        } else {
                            System.out.println("3");
                        }
                    }
                } else if (lineScreener(arr1[1][0], arr1[0][0], arr2[i][0], arr1[1][1], arr1[0][1], arr2[i][1]) == 0) {
                    if (arr2[i][0] < arr1[1][1] && arr2[i][0] > arr1[0][1] && arr2[i][0] > arr1[1][1] && arr2[i][0] < arr1[0][1]) {
                        System.out.println("1");
                    }
                } else {
                    System.out.println("3");
                }
            }
        }
    }
    static double [][] highRight (double arr[][]) {
        int indexOfHigh = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[indexOfHigh][1] < arr[i][1]) {
                indexOfHigh = i;
            }
        }
        if (arr[indexOfHigh][1] == arr[indexOfHigh + 1][1]) {
            if (arr[indexOfHigh][0] < arr[indexOfHigh + 1][0]) {
                indexOfHigh++;
            }
        }
        double arr1[][] = new double[4][2];
        for (int i = 0; i < 4; i++) {
            arr1[i][0] = arr[(i + indexOfHigh) % 4][0];
            arr1[i][1] = arr[(i + indexOfHigh) % 4][1];
        }
        return arr1;
    }
}