package task2;

import java.io.*;

public class task2 {
    public static void main(String[] args) throws Exception {
        double[][] rectanglePoints = readFile(args[0]);
        double[][] points = readFile(args[1]);
        rectanglePoints = calculateTopRight(rectanglePoints);
        calculateAttachment(rectanglePoints, points);
    }

    static double[][] readFile(String filename) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String data;
        int counter = 0;
        double[][] input1 = new double[100][2];
        while ((data = in.readLine()) != null) {
            String[] sp = data.split(" ");
            input1[counter][0] = Double.parseDouble(sp[0]);
            input1[counter][1] = Double.parseDouble(sp[1]);
            counter++;
        }
        double[][] input = new double[counter][2];
        for (int i = 0; i < counter; i++) {
            System.arraycopy(input1[i], 0, input[i], 0, 2);
        }
        return input;
    }

    static double lineScreener(double x1, double x2, double x, double y1, double y2, double y) {
        return y - x * (y2 - y1) / (x2 - x1) + (x1 * y2 - x2 * y1) / (x2 - x1);
    }

    static double lineSign(double x1, double x2, double y1, double y2) {
        return (y2 - y1) / (x2 - x1);
    }

    static void calculateAttachment(double[][] rectanglePoints, double[][] points) {
        for (double[] point : points) {
            if (point[0] == rectanglePoints[0][0] && point[1] == rectanglePoints[0][1] ||
                    point[0] == rectanglePoints[1][0] && point[1] == rectanglePoints[1][1] ||
                    point[0] == rectanglePoints[2][0] && point[1] == rectanglePoints[2][1] ||
                    point[0] == rectanglePoints[3][0] && point[1] == rectanglePoints[3][1]) {
                System.out.println("0");
            } else {
                if (rectanglePoints[0][0] - rectanglePoints[1][0] == 0) {
                    if (point[0] == rectanglePoints[0][0]) {
                        if (point[1] < rectanglePoints[0][1] && point[1] > rectanglePoints[1][1]) {
                            System.out.println("1");
                        } else {
                            System.out.println("3");
                        }
                    } else if (point[0] - rectanglePoints[0][0] > 0) {
                        System.out.println("3");
                    } else {
                        if (rectanglePoints[2][1] == rectanglePoints[1][1]) {
                            if (point[1] == rectanglePoints[1][1]) {
                                if (point[0] > rectanglePoints[2][1] && point[0] < rectanglePoints[1][1]) {
                                    System.out.println("1");
                                } else {
                                    System.out.println("3");
                                }
                            } else if (point[1] - rectanglePoints[1][1] < 0) {
                                System.out.println("3");
                            } else {
                                if (rectanglePoints[3][0] == rectanglePoints[2][0]) {
                                    if (point[0] == points[2][0]) {
                                        if (point[1] < rectanglePoints[3][1] && point[1] > rectanglePoints[2][1]) {
                                            System.out.println("1");
                                        } else {
                                            System.out.println("3");
                                        }
                                    } else if (point[0] < points[2][0]) {
                                        System.out.println("3");
                                    } else {
                                        if (rectanglePoints[3][1] == rectanglePoints[0][1]) {
                                            if (point[1] == rectanglePoints[3][1]) {
                                                if (point[0] > rectanglePoints[3][1] && point[0] < rectanglePoints[0][1]) {
                                                    System.out.println("1");
                                                } else {
                                                    System.out.println("3");
                                                }
                                            } else if (point[1] - rectanglePoints[3][1] > 0) {
                                                System.out.println("3");
                                            } else {
                                                System.out.println("2");
                                            }
                                        } else {
                                            if (lineScreener(rectanglePoints[3][0], rectanglePoints[0][0], point[0], rectanglePoints[3][1], rectanglePoints[0][1], point[1]) < 0) {
                                                System.out.println("2");
                                            } else if (lineScreener(rectanglePoints[3][0], rectanglePoints[0][0], point[0], rectanglePoints[3][1], rectanglePoints[0][1], point[1]) == 0) {
                                                if (point[0] < rectanglePoints[0][0] && point[0] > rectanglePoints[3][0] || point[0] > rectanglePoints[0][0] && point[0] < rectanglePoints[3][0]) {
                                                    System.out.println("2");
                                                }
                                            } else {
                                                System.out.println("3");
                                            }
                                        }
                                    }
                                } else {
                                    if (lineScreener(rectanglePoints[2][0], rectanglePoints[3][0], point[0], rectanglePoints[2][1], rectanglePoints[3][1], point[1]) * lineSign(rectanglePoints[2][0], rectanglePoints[3][0], rectanglePoints[2][1], rectanglePoints[3][1]) < 0) {
                                        if (rectanglePoints[3][1] == rectanglePoints[0][1]) {
                                            if (point[1] == rectanglePoints[3][1]) {
                                                if (point[0] > rectanglePoints[3][1] && point[0] < rectanglePoints[0][1]) {
                                                    System.out.println("1");
                                                } else {
                                                    System.out.println("3");
                                                }
                                            } else if (point[1] - rectanglePoints[3][1] > 0) {
                                                System.out.println("3");
                                            } else {
                                                System.out.println("2");
                                            }
                                        } else {
                                            if (lineScreener(rectanglePoints[3][0], rectanglePoints[0][0], point[0], rectanglePoints[3][1], rectanglePoints[0][1], point[1]) < 0) {
                                                System.out.println("2");
                                            } else if (lineScreener(rectanglePoints[3][0], rectanglePoints[0][0], point[0], rectanglePoints[3][1], rectanglePoints[0][1], point[1]) == 0) {
                                                if (point[0] < rectanglePoints[0][0] && point[0] > rectanglePoints[3][0] || point[0] > rectanglePoints[0][0] && point[0] < rectanglePoints[3][0]) {
                                                    System.out.println("2");
                                                }
                                            } else {
                                                System.out.println("3");
                                            }
                                        }
                                    } else if (lineScreener(rectanglePoints[2][0], rectanglePoints[3][0], point[0], rectanglePoints[2][1], rectanglePoints[3][1], point[1]) == 0) {
                                        if (point[1] < rectanglePoints[2][1] && point[1] > rectanglePoints[3][1] || point[1] > rectanglePoints[2][1] && point[1] < rectanglePoints[3][1]) {
                                            System.out.println("1");
                                        }
                                    } else {
                                        System.out.println("3");
                                    }
                                }
                            }
                        } else {
                            if (lineScreener(rectanglePoints[2][0], rectanglePoints[1][0], point[0], rectanglePoints[2][1], rectanglePoints[1][1], point[1]) > 0) {
                                if (rectanglePoints[3][0] == rectanglePoints[2][0]) {
                                    if (point[0] == points[2][0]) {
                                        if (point[1] < rectanglePoints[3][1] && point[1] > rectanglePoints[2][1]) {
                                            System.out.println("1");
                                        } else {
                                            System.out.println("3");
                                        }
                                    } else if (point[0] < points[2][0]) {
                                        System.out.println("3");
                                    } else {
                                        if (rectanglePoints[3][1] == rectanglePoints[0][1]) {
                                            if (point[1] == rectanglePoints[3][1]) {
                                                if (point[0] > rectanglePoints[3][1] && point[0] < rectanglePoints[0][1]) {
                                                    System.out.println("1");
                                                } else {
                                                    System.out.println("3");
                                                }
                                            } else if (point[1] - rectanglePoints[3][1] > 0) {
                                                System.out.println("3");
                                            } else {
                                                System.out.println("2");
                                            }
                                        } else {
                                            if (lineScreener(rectanglePoints[3][0], rectanglePoints[0][0], point[0], rectanglePoints[3][1], rectanglePoints[0][1], point[1]) < 0) {
                                                System.out.println("2");
                                            } else if (lineScreener(rectanglePoints[3][0], rectanglePoints[0][0], point[0], rectanglePoints[3][1], rectanglePoints[0][1], point[1]) == 0) {
                                                if (point[0] < rectanglePoints[0][0] && point[0] > rectanglePoints[3][0] || point[0] > rectanglePoints[0][0] && point[0] < rectanglePoints[3][0]) {
                                                    System.out.println("2");
                                                }
                                            } else {
                                                System.out.println("3");
                                            }
                                        }
                                    }
                                } else {
                                    if (lineScreener(rectanglePoints[2][0], rectanglePoints[3][0], point[0], rectanglePoints[2][1], rectanglePoints[3][1], point[1]) * lineSign(rectanglePoints[2][0], rectanglePoints[3][0], rectanglePoints[2][1], rectanglePoints[3][1]) < 0) {
                                        if (rectanglePoints[3][1] == rectanglePoints[0][1]) {
                                            if (point[1] == rectanglePoints[3][1]) {
                                                if (point[0] > rectanglePoints[3][1] && point[0] < rectanglePoints[0][1]) {
                                                    System.out.println("1");
                                                } else {
                                                    System.out.println("3");
                                                }
                                            } else if (point[1] - rectanglePoints[3][1] > 0) {
                                                System.out.println("3");
                                            } else {
                                                System.out.println("2");
                                            }
                                        } else {
                                            if (lineScreener(rectanglePoints[3][0], rectanglePoints[0][0], point[0], rectanglePoints[3][1], rectanglePoints[0][1], point[1]) < 0) {
                                                System.out.println("2");
                                            } else if (lineScreener(rectanglePoints[3][0], rectanglePoints[0][0], point[0], rectanglePoints[3][1], rectanglePoints[0][1], point[1]) == 0) {
                                                if (point[0] < rectanglePoints[0][0] && point[0] > rectanglePoints[3][0] || point[0] > rectanglePoints[0][0] && point[0] < rectanglePoints[3][0]) {
                                                    System.out.println("2");
                                                }
                                            } else {
                                                System.out.println("3");
                                            }
                                        }
                                    } else if (lineScreener(rectanglePoints[2][0], rectanglePoints[3][0], point[0], rectanglePoints[2][1], rectanglePoints[3][1], point[1]) == 0) {
                                        if (point[1] < rectanglePoints[2][1] && point[1] > rectanglePoints[3][1] || point[1] > rectanglePoints[2][1] && point[1] < rectanglePoints[3][1]) {
                                            System.out.println("1");
                                        }
                                    } else {
                                        System.out.println("3");
                                    }
                                }
                            } else if (lineScreener(rectanglePoints[2][0], rectanglePoints[1][0], point[0], rectanglePoints[2][1], rectanglePoints[1][1], point[1]) == 0) {
                                if (point[0] < rectanglePoints[1][0] && point[0] > rectanglePoints[2][0] && point[0] > rectanglePoints[1][0] && point[0] < rectanglePoints[2][0]) {
                                    System.out.println("1");
                                }
                            } else {
                                System.out.println("3");
                            }
                        }
                    }
                } else {
                    if (lineScreener(rectanglePoints[1][0], rectanglePoints[0][0], point[0], rectanglePoints[1][1], rectanglePoints[0][1], point[1]) * lineSign(rectanglePoints[1][0], rectanglePoints[0][0], rectanglePoints[1][1], rectanglePoints[0][1]) > 0) {
                        if (rectanglePoints[2][1] == rectanglePoints[1][1]) {
                            if (point[1] == rectanglePoints[1][1]) {
                                if (point[0] > rectanglePoints[2][1] && point[0] < rectanglePoints[1][1]) {
                                    System.out.println("1");
                                } else {
                                    System.out.println("3");
                                }
                            } else if (point[1] - rectanglePoints[1][1] < 0) {
                                System.out.println("3");
                            } else {
                                if (rectanglePoints[3][0] == rectanglePoints[2][0]) {
                                    if (point[0] == points[2][0]) {
                                        if (point[1] < rectanglePoints[3][1] && point[1] > rectanglePoints[2][1]) {
                                            System.out.println("1");
                                        } else {
                                            System.out.println("3");
                                        }
                                    } else if (point[0] < points[2][0]) {
                                        System.out.println("3");
                                    } else {
                                        if (rectanglePoints[3][1] == rectanglePoints[0][1]) {
                                            if (point[1] == rectanglePoints[3][1]) {
                                                if (point[0] > rectanglePoints[3][1] && point[0] < rectanglePoints[0][1]) {
                                                    System.out.println("1");
                                                } else {
                                                    System.out.println("3");
                                                }
                                            } else if (point[1] - rectanglePoints[3][1] > 0) {
                                                System.out.println("3");
                                            } else {
                                                System.out.println("2");
                                            }
                                        } else {
                                            if (lineScreener(rectanglePoints[3][0], rectanglePoints[0][0], point[0], rectanglePoints[3][1], rectanglePoints[0][1], point[1]) < 0) {
                                                System.out.println("2");
                                            } else if (lineScreener(rectanglePoints[3][0], rectanglePoints[0][0], point[0], rectanglePoints[3][1], rectanglePoints[0][1], point[1]) == 0) {
                                                if (point[0] < rectanglePoints[0][0] && point[0] > rectanglePoints[3][0] || point[0] > rectanglePoints[0][0] && point[0] < rectanglePoints[3][0]) {
                                                    System.out.println("2");
                                                }
                                            } else {
                                                System.out.println("3");
                                            }
                                        }
                                    }
                                } else {
                                    if (lineScreener(rectanglePoints[2][0], rectanglePoints[3][0], point[0], rectanglePoints[2][1], rectanglePoints[3][1], point[1]) * lineSign(rectanglePoints[2][0], rectanglePoints[3][0], rectanglePoints[2][1], rectanglePoints[3][1]) < 0) {
                                        if (rectanglePoints[3][1] == rectanglePoints[0][1]) {
                                            if (point[1] == rectanglePoints[3][1]) {
                                                if (point[0] > rectanglePoints[3][1] && point[0] < rectanglePoints[0][1]) {
                                                    System.out.println("1");
                                                } else {
                                                    System.out.println("3");
                                                }
                                            } else if (point[1] - rectanglePoints[3][1] > 0) {
                                                System.out.println("3");
                                            } else {
                                                System.out.println("2");
                                            }
                                        } else {
                                            if (lineScreener(rectanglePoints[3][0], rectanglePoints[0][0], point[0], rectanglePoints[3][1], rectanglePoints[0][1], point[1]) < 0) {
                                                System.out.println("2");
                                            } else if (lineScreener(rectanglePoints[3][0], rectanglePoints[0][0], point[0], rectanglePoints[3][1], rectanglePoints[0][1], point[1]) == 0) {
                                                if (point[0] < rectanglePoints[0][0] && point[0] > rectanglePoints[3][0] || point[0] > rectanglePoints[0][0] && point[0] < rectanglePoints[3][0]) {
                                                    System.out.println("2");
                                                }
                                            } else {
                                                System.out.println("3");
                                            }
                                        }
                                    } else if (lineScreener(rectanglePoints[2][0], rectanglePoints[3][0], point[0], rectanglePoints[2][1], rectanglePoints[3][1], point[1]) == 0) {
                                        if (point[1] < rectanglePoints[2][1] && point[1] > rectanglePoints[3][1] || point[1] > rectanglePoints[2][1] && point[1] < rectanglePoints[3][1]) {
                                            System.out.println("1");
                                        }
                                    } else {
                                        System.out.println("3");
                                    }
                                }
                            }
                        } else {
                            if (lineScreener(rectanglePoints[2][0], rectanglePoints[1][0], point[0], rectanglePoints[2][1], rectanglePoints[1][1], point[1]) > 0) {
                                if (rectanglePoints[3][0] == rectanglePoints[2][0]) {
                                    if (point[0] == points[2][0]) {
                                        if (point[1] < rectanglePoints[3][1] && point[1] > rectanglePoints[2][1]) {
                                            System.out.println("1");
                                        } else {
                                            System.out.println("3");
                                        }
                                    } else if (point[0] < points[2][0]) {
                                        System.out.println("3");
                                    } else {
                                        if (rectanglePoints[3][1] == rectanglePoints[0][1]) {
                                            if (point[1] == rectanglePoints[3][1]) {
                                                if (point[0] > rectanglePoints[3][1] && point[0] < rectanglePoints[0][1]) {
                                                    System.out.println("1");
                                                } else {
                                                    System.out.println("3");
                                                }
                                            } else if (point[1] - rectanglePoints[3][1] > 0) {
                                                System.out.println("3");
                                            } else {
                                                System.out.println("2");
                                            }
                                        } else {
                                            if (lineScreener(rectanglePoints[3][0], rectanglePoints[0][0], point[0], rectanglePoints[3][1], rectanglePoints[0][1], point[1]) < 0) {
                                                System.out.println("2");
                                            } else if (lineScreener(rectanglePoints[3][0], rectanglePoints[0][0], point[0], rectanglePoints[3][1], rectanglePoints[0][1], point[1]) == 0) {
                                                if (point[0] < rectanglePoints[0][0] && point[0] > rectanglePoints[3][0] || point[0] > rectanglePoints[0][0] && point[0] < rectanglePoints[3][0]) {
                                                    System.out.println("2");
                                                }
                                            } else {
                                                System.out.println("3");
                                            }
                                        }
                                    }
                                } else {
                                    if (lineScreener(rectanglePoints[2][0], rectanglePoints[3][0], point[0], rectanglePoints[2][1], rectanglePoints[3][1], point[1]) * lineSign(rectanglePoints[2][0], rectanglePoints[3][0], rectanglePoints[2][1], rectanglePoints[3][1]) < 0) {
                                        if (rectanglePoints[3][1] == rectanglePoints[0][1]) {
                                            if (point[1] == rectanglePoints[3][1]) {
                                                if (point[0] > rectanglePoints[3][1] && point[0] < rectanglePoints[0][1]) {
                                                    System.out.println("1");
                                                } else {
                                                    System.out.println("3");
                                                }
                                            } else if (point[1] - rectanglePoints[3][1] > 0) {
                                                System.out.println("3");
                                            } else {
                                                System.out.println("2");
                                            }
                                        } else {
                                            if (lineScreener(rectanglePoints[3][0], rectanglePoints[0][0], point[0], rectanglePoints[3][1], rectanglePoints[0][1], point[1]) < 0) {
                                                System.out.println("2");
                                            } else if (lineScreener(rectanglePoints[3][0], rectanglePoints[0][0], point[0], rectanglePoints[3][1], rectanglePoints[0][1], point[1]) == 0) {
                                                if (point[0] < rectanglePoints[0][0] && point[0] > rectanglePoints[3][0] || point[0] > rectanglePoints[0][0] && point[0] < rectanglePoints[3][0]) {
                                                    System.out.println("2");
                                                }
                                            } else {
                                                System.out.println("3");
                                            }
                                        }
                                    } else if (lineScreener(rectanglePoints[2][0], rectanglePoints[3][0], point[0], rectanglePoints[2][1], rectanglePoints[3][1], point[1]) == 0) {
                                        if (point[1] < rectanglePoints[2][1] && point[1] > rectanglePoints[3][1] || point[1] > rectanglePoints[2][1] && point[1] < rectanglePoints[3][1]) {
                                            System.out.println("1");
                                        }
                                    } else {
                                        System.out.println("3");
                                    }
                                }
                            } else if (lineScreener(rectanglePoints[2][0], rectanglePoints[1][0], point[0], rectanglePoints[2][1], rectanglePoints[1][1], point[1]) == 0) {
                                if (point[0] < rectanglePoints[1][0] && point[0] > rectanglePoints[2][0] && point[0] > rectanglePoints[1][0] && point[0] < rectanglePoints[2][0]) {
                                    System.out.println("1");
                                }
                            } else {
                                System.out.println("3");
                            }
                        }
                    } else if (lineScreener(rectanglePoints[1][0], rectanglePoints[0][0], point[0], rectanglePoints[1][1], rectanglePoints[0][1], point[1]) == 0) {
                        if (point[0] < rectanglePoints[1][1] && point[0] > rectanglePoints[0][1] && point[0] > rectanglePoints[1][1] && point[0] < rectanglePoints[0][1]) {
                            System.out.println("1");
                        }
                    } else {
                        System.out.println("3");
                    }
                }
            }
        }
    }

    static double[][] calculateTopRight(double[][] arr) {
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
        double[][] arr1 = new double[4][2];
        for (int i = 0; i < 4; i++) {
            arr1[i][0] = arr[(i + indexOfHigh) % 4][0];
            arr1[i][1] = arr[(i + indexOfHigh) % 4][1];
        }
        return arr1;
    }
}