from deepface import DeepFace
import cv2
import matplotlib.pyplot as plt

img1_path = "Images/Colin1.png"
img2_path = "Images/Colin2.png"

img1 = cv2.imread(img1_path)
img2 = cv2.imread(img2_path)

plt.imshow(img1[:, :, ::-1])
plt.imshow(img2[:, :, ::-1])

result = DeepFace.verify(img1_path, img2_path)
print(result)