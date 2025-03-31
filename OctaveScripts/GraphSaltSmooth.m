  x = [0];
  y = [0];
  windowSize = [8, 5];


% graph initial function
for i = 1:50
  x = [x; i];
  y = [y; i ^ 1.5 * .5];
endfor
plot(x, y);
hold on;

% graph salted data
index = 1
while(index <= length(x))
 y(index) = y(index) + (rand * 50 - 25);
 index = index + 1;
endwhile

plot(x, y)

% graph smoothed function
index = 1;
windowIndex = 1;
while(windowIndex <= length(windowSize))
  while(index <= length(x))
    avg = 0;
    sum = 0;

    leftWindow = min(windowSize(windowIndex), index - 1);
    subIndex = 1;
    while (subIndex <= leftWindow)
      sum = sum + y(index - subIndex);
      subIndex = subIndex + 1;
      avg = avg + 1;
    endwhile

    rightWindow = min(windowSize(windowIndex), length(x) - index);
    subIndex = 1;
    while (subIndex <= rightWindow)
      sum = sum + y(index + subIndex);
      subIndex = subIndex + 1;
      avg = avg + 1;
    endwhile

    sum = sum + y(index);
    avg = avg + 1;

    if avg > 0
      y(index) = sum / avg;
    endif

    index = index + 1;
  endwhile
  windowIndex = windowIndex + 1;
endwhile

plot(x, y);

hold off;

