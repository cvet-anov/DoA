class Prezentacii:
    def maxPrezentacii(self, N, sf):
        count = 0
        vreme = 0
        prezentacii=[]
        for i in range(N):
            prezentacii.append((sf[2*i], sf[2*i + 1]))
        prezentacii.sort(key=lambda p: p[1])
        for x, y in prezentacii:
            if x < vreme:
                continue
            vreme = y
            count += 1

        return count